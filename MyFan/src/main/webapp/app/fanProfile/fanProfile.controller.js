(function() {
    'use strict';
    angular
        .module('refiereApp.fanProfile')
        .controller('fanProfileCtrl', fanProfileCtrl);

    fanProfileCtrl.$inject = ['FanaticSrv', '$log', '$uibModal', '$state', '$window', '$scope', 'UserDataService','$cookies','$cookieStore'];

    function fanProfileCtrl(FanaticSrv, $log, $uibModal, $state, $window, $scope, UserDataService,$cookies,$cookieStore) {
        var vm = this;

        $scope.totalItems = 60;
        $scope.currentPage = 1;

        vm.currentEvent = {};
        vm.newUser = {};
        vm.genresList = {};
        vm.countriesList = {};
        vm.timelineParameters = {};
        vm.timeline = [];
        vm.artistList=[];
        vm.userData = $cookies.getObject('userInfo');
        vm.timelineParameters.offset = '0';

        vm.unfollowParameters = {};
        vm.unfollowParameters.idUserFanatic = vm.userData.UserId;

        vm.searchParameters={
          name:"",
          nameGenre:"",
          nameUbication:""
        };

        vm.searchResults={};
        permissions();
        vm.open = function(size, title, body, stars, commentsAmount, date, id) {
            vm.currentEvent.title = title;
            vm.currentEvent.body = body;
            vm.currentEvent.stars = stars;
            vm.currentEvent.commentsAmount = commentsAmount;
            vm.currentEvent.date = date;
            vm.currentEvent.id = id;
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
              getUserData();
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

        vm.goToArtistProfile=function(data){
          $cookies.put("idArtist",data);
          console.log(data);
          console.log($cookies.get("idArtist"));
          $state.go("artistProfile")
        }

          vm.getFollowedArtist = function () {
            vm.artistList=[];
            vm.timelineParameters.idUser = vm.userData.UserId;
            FanaticSrv.getFollowedArtist(vm.timelineParameters)
                .then(function(followedArtitsData) {
                    for (var i = 0; i < followedArtitsData.data.length; i++) {
                        vm.artistList.push(followedArtitsData.data[i]);
                    }
                });
        }

        vm.unfollowArtist = function (artistId) {
          vm.unfollowParameters.idUserArtist = artistId;
          console.log(vm.unfollowParameters);
          FanaticSrv.postUnfollowStatus(vm.unfollowParameters)
          .then(function(unfollowData){
              console.log("unfollow exitoso");
          });
        }


        vm.search = function(){
          FanaticSrv.searchData(vm.searchParameters)
              .then(function(searchData) {
                vm.searchResults=searchData.data;
              });
        }

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
