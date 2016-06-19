(function() {
    'use strict';
    angular
        .module('refiereApp.fanProfile')
        .controller('fanProfileCtrl', fanProfileCtrl);

    fanProfileCtrl.$inject = ['FanaticSrv', '$log', '$uibModal', '$state', '$window', '$scope', 'UserDataService','$cookies','$cookieStore'];

    function fanProfileCtrl(FanaticSrv, $log, $uibModal, $state, $window, $scope, UserDataService,$cookies,$cookieStore) {
        var vm = this;
        vm.currentEvent = {};
        vm.currentUser ={
          rol: "fanatic",
          id: 10
        };
        vm.newUser = {};
        vm.genresList = {};
        vm.countriesList = {};
        vm.timelineParameters = {};
        vm.timeline = [];
        vm.userData = $cookies.getObject('userInfo');
        vm.timelineParameters.offset = '0';

        permissions();

        vm.open = function(size, title, content, stars, commentsAmount) {
            vm.currentEvent.title = title;
            vm.currentEvent.content = content;
            vm.currentEvent.stars = stars;
            vm.currentEvent.commentsAmount = commentsAmount;
            console.log(vm.currentEvent);
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/modalEvent/view.html',
                controller: 'ModalInstanceCtrl',
                size: size,
                resolve: {
                    currentEvent: function() {
                        return vm.currentEvent;
                    }
                }
            });
            modalInstance.result.then(function(selectedItem) {
                $scope.selected = selectedItem;
            }, function() {
                $log.info('Modal dismissed at: ' + new Date());
            });


        };

        vm.openEditFan= function(size) {
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/editFan/view.html',
                controller: 'editFanCtrl',
                size: size,
                resolve: {
                    currentUser: function() {
                        return vm.currentUser;
                    }
                }

            });
            modalInstance.result.then(function(selectedItem) {
                $scope.selected = selectedItem;
            }, function() {
                $log.info('Modal dismissed at: ' + new Date());
            });


        };


        function permissions(){
          if( vm.userData==null){
            console.log(vm.userData)
            $state.go('404')
          }
          else{
            getUserData();
          }
        }
        vm.sessionClose = function sessionClose(){
          $cookies.remove('userInfo');
          $state.go('login');
        }
        function getUserData() {
            FanaticSrv.getUserData(vm.userData)
                .then(function(info) {
                    vm.newUser = info.data;

                })
        }

        function getGenresData(data) {
            FanaticSrv.getGenresData()
                .then(function(info) {
                    vm.genresList = info.data;
                })
        }

        function getUbicationsList() {
            FanaticSrv.getUbicationsList()
                .then(function(ubicationData) {
                    vm.countriesList = ubicationData.data;
                })
        }
        getTimelineNews();

        function getTimelineNews() {
            vm.timelineParameters.idUser = vm.userData.UserId ;
            FanaticSrv.getTimelineNews(vm.timelineParameters)
                .then(function(newsData) {
                    for (var i = 0; i < newsData.data.length; i++) {
                        vm.timeline.push(newsData.data[i]);
                    }
                });
        }

        getTimelineEvents();

        function getTimelineEvents() {
            vm.timelineParameters.idUser = vm.userData.UserId;
            FanaticSrv.getTimelineEvents(vm.timelineParameters)
                .then(function(eventsData) {
                    for (var i = 0; i < eventsData.data.length; i++) {
                        vm.timeline.push(eventsData.data[i]);
                    }
                });
        }


        vm.artistList = {
            artists: [{
                name: "Red Hot Chili Peppers",
                photo: "",
                country: "Estados Unidos",
                albumsAmount: 20,
                stars: 5,
                genres: [
                    "Rock",
                    "Pop",
                    "Funk",
                    "Alternativo"
                ],
                nextEvent: "Se presentan el 20 de octubre, en el Super Rock Festival",
            }, {
                name: "Bob Marley",
                photo: "",
                country: "Jamaica",
                albumsAmount: 5,
                stars: 3,
                genres: [
                    "Reggae",
                    "Ska",
                    "Funk",
                    "Dub",
                    "Quinto"
                ],
                nextEvent: "No tiene eventos próximos",
            }, {
                name: "Gorillaz",
                photo: "",
                country: "Estados Unidos",
                albumsAmount: 20,
                stars: 5,
                genres: [
                    "Rock alt",
                    "Rock electronico",
                    "Hip Hop",
                    "Alternativo",
                    "Dub"
                ],
                nextEvent: "Se presentarán en diciembre en el London UFK Festival",
            }, ]
        };





        $scope.filtersInvisible = true;
        $scope.showFilters = function() {
            if ($scope.filtersInvisible) {
                $scope.filtersInvisible = false;
                getGenresData();
                getUbicationsList();
            } else {
                $scope.filtersInvisible = true;
            }

        };
    }
})();
