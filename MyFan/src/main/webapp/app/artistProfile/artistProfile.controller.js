(function() {
    'use strict';
    angular
        .module('refiereApp.artistProfile')
        .controller('artistProfileCtrl', artistProfileCtrl);

    artistProfileCtrl.$inject = ['ArtistSrv','$uibModal', '$state', '$window', '$scope'];

    function artistProfileCtrl(ArtistSrv, $uibModal, $state, $window, $scope) {
        var vm = this;
        vm.currentUser = {};
        vm.currentEvent = {};
        vm.userData={};
        vm.timeline=[];
        vm.timelineParameters = {};
        vm.timelineParameters.offset = '0';


        vm.currentUser ={
          type: "fanatic",
          id: "101",
          userName: "Alejandro22",
          name: "Alejandro",
        }


        vm.getDiscography = function(){
          $scope.switchContent(true);
          vm.timelineParameters.idUser = '11';
          ArtistSrv.getDiscography(vm.timelineParameters)
              .then(function(discographyData) {
                  vm.discography = discographyData.data;
              });
        }

        getTimelineNews();
        function getTimelineNews() {
            vm.timelineParameters.idUser = '11';
            ArtistSrv.getTimelineNews(vm.timelineParameters)
                .then(function(newsData) {
                    for (var i = 0; i < newsData.data.length; i++) {
                        vm.timeline.push(newsData.data[i]);
                        console.log(newsData.data);
                    }
                });
        }

        getTimelineEvents();

        function getTimelineEvents() {
            vm.timelineParameters.idUser = '11';
            ArtistSrv.getTimelineEvents(vm.timelineParameters)
                .then(function(eventsData) {
                    for (var i = 0; i < eventsData.data.length; i++) {
                        vm.timeline.push(eventsData.data[i]);
                    }
                });
        }
        getUserData();
        function getUserData() {
          vm.userData.UserId='11';
            ArtistSrv.getUserData(vm.userData)
                .then(function(info) {
                    vm.artistProfile = info.data;

                })
        }
        vm.openEventModal = function(size, title, body, stars, commentsAmount) {
            vm.currentEvent.title = title;
            vm.currentEvent.body = body;
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

        vm.openAlbumModal = function(size) {
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/modalAlbum/view.html',
                controller: 'modalAlbumCtrl',
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

        vm.openEditArtist= function(size) {
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/editArtist/view.html',
                controller: 'editArtistCtrl',
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

        vm.createEventModal = function(size) {
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/createEvent/view.html',
                controller: 'createEventCtrl',
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

        vm.createNewsModal = function(size) {
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/createNews/view.html',
                controller: 'createNewsCtrl',
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

        vm.createAlbumModal = function(size) {
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/createAlbum/view.html',
                controller: 'createAlbumCtrl',
                size: size,
                resolve: {
                    currentUser: function() {
                        return vm.currentUser;
                    }
                }

            });
            modalInstance.result.then(function(selectedItem) {
                vm.getDiscography();
            }, function() {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };



        vm.currentUser ={
          type: "artist",
          id: "101",
          userName: "Alejandro22",
          name: "Alejandro",
        }

        vm.artistCommentsList = {
            comments: [{
                    author: "Alejandro",
                    body: "Para mi es un objecto de culto. Su voz y su musica son una pura expresion de fe. con el te lleva casi al más alla. es uno de los padre del movimiento hippie, uno de los mas carismaticos.",
                    stars: 3
                }, {
                    author: "RastaGirl201",
                    body: "Aunque esté muerto su estilo perdurará por siempre y es el rey del regge y de África. - Ventajas: Puro Regge, Aún vive su espíritu - Desventajas: Por desgracia para todos no está presente :(",
                    stars: 5
                }

            ]
        }

        $scope.following = "¡Seguir artista!";
        $scope.link = 'https://www.youtube.com/watch?v=mGNRAzW0BdI';
        $scope.centerCol = 'col-xs-7 col-md-7';
        $scope.rightCol = 'col-xs-3 col-md-3';
        $scope.showVid = false;
        $scope.x = 0; //valor inicial de calificacion;
        $scope.switchContent = function(toggle) {
            if (toggle) {
                $scope.centerCol = 'col-xs-6 col-md-6';
                $scope.rightCol = 'col-xs-4 col-md-4';
                $scope.showVid = true;
            } else {
                $scope.centerCol = 'col-xs-7 col-md-7';
                $scope.rightCol = 'col-xs-3 col-md-3';
                $scope.showVid = false;
            }

        }
        $scope.toggleFollowing = function() {
            if ($scope.following === "¡Seguir artista!") {
                $scope.following = "¡Dejar de seguir artista!";
            } else {
                $scope.following = "¡Seguir artista!";
            }
        };
        $scope.goBackToProfile = function() {
            $window.location.href = 'fanProfile.html';
        };
        $scope.g = function() {
            console.log("aa");
        }
    }

})();
