(function() {
    'use strict';
    angular
        .module('refiereApp.artistProfile')
        .controller('artistProfileCtrl', artistProfileCtrl);

    artistProfileCtrl.$inject = ['ArtistSrv','$uibModal', '$state', '$window', '$scope'];

    function artistProfileCtrl(ArtistSrv, $uibModal, $state, $window, $scope) {
        var vm = this;
        vm.currentEvent = {};
        vm.userData={};
        vm.timeline=[];
        vm.timelineParameters = {};
        vm.timelineParameters.offset = '0';
        vm.currentAlbumInfo = {};
        $scope.link = 'https://www.youtube.com/watch?v=mGNRAzW0BdI';

        $scope.artistRating = {};
        $scope.artistRating.idUserArtist = "11";
        $scope.artistRating.idUserFanatic = "12";
        $scope.artist = {};
        $scope.artist.id = "11";
        $scope.artist.idArtist = "11";


        vm.followParameters = {};
        vm.followParameters.idUserFanatic = "12";
        vm.followParameters.idUserArtist = "11";


        vm.currentUser ={
          type: "artist",
          id: "101",
          userName: "Alejandro22",
          name: "Alejandro",
        }


//------------------------------CANCELA Y ELIMINAR PUBLICACIONES------------------------------------


      vm.newsDelete = {};
      vm.eventCancel = {};


        vm.deleteNews = function (newsId){
          vm.newsDelete.newsId = newsId;
          ArtistSrv.postDeleteNews(vm.newsDelete)
          .then(function(data){
          $state.reload();
              console.log("¡Borré noticia!");
          }).catch((error) => {
            console.log("Error al intentar borrar noticia");
          });
        };

        vm.cancelEvent = function (eventId){
          vm.eventCancel.idEvent = eventId;
          ArtistSrv.postCancelEvent(vm.eventCancel)
          .then(function(data){
            $state.reload();
            console.log("¡Cancelé evento!");
        }).catch((error) => {
          console.log(vm.eventCancel);
          console.log("Error al intentar cancelar evento");
          });
        };



//------------------------------CANCELA Y ELIMINAR PUBLICACIONES------------------------------------


        getArtistComments();
        function getArtistComments(){
          ArtistSrv.getArtistComments($scope.artist)
          .then(function(commentsData){
              $scope.artistComments = commentsData.data;
              console.log(commentsData.data);
              console.log("arriba comments de Artist");
          });
        }

        vm.followArtist = function () {
          console.log(vm.followParameters);
          ArtistSrv.postFollowStatus(vm.followParameters)
          .then(function(followData){
              $scope.following =!$scope.following;
              console.log("follow exitoso");
          });
        };

        vm.unFollowArtist = function () {
          console.log(vm.followParameters);
          ArtistSrv.postUnfollowStatus(vm.followParameters)
          .then(function(followData){
              $scope.following =!$scope.following;
              console.log("unfollow exitoso");
          });
        };

        getFollowingStatus();
        function getFollowingStatus () {
          console.log(vm.followParameters);
          ArtistSrv.postGetFollowingStatus(vm.followParameters)
          .then(function(followData){
              $scope.following = !followData.data.following;
              console.log("followstatus exitoso");
              console.log("estado: " + followData.data.following);
          });
        }

        $scope.sendRateArtist = function(){
          console.log($scope.artistRating);
          ArtistSrv.postRateArtist($scope.artistRating)
          .then(function(data){
            getArtistComments();
            console.log(data);
          })
          .catch(function(error) {
            console.log(error);
            $window.alert('No se pudo calificar artista :( ');
          });

        }



        vm.changeVideo = function (videoLink){
          $scope.link = videoLink;
          console.log("aaasd");
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
        vm.openEventModal = function(size, title, body, stars, commentsAmount, date, id) {
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

        vm.openAlbumModal = function(size, title, desc, genre, year, songsNum, label, id) {
            vm.currentAlbumInfo.title = title;
            vm.currentAlbumInfo.desc = desc;
            vm.currentAlbumInfo.genre = genre;
            vm.currentAlbumInfo.year = year;
            vm.currentAlbumInfo.songsNum = songsNum;
            vm.currentAlbumInfo.label = label;
            vm.currentAlbumInfo.idDisc = id;
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/modalAlbum/view.html',
                controller: 'modalAlbumCtrl',
                size: size,
                resolve: {
                    currentAlbumInfo: function() {
                        return vm.currentAlbumInfo;
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
              vm.timeline = [];
              getTimelineEvents();
              getTimelineNews();
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
              vm.timeline = [];
              getTimelineEvents();
              getTimelineNews();
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

        $scope.following =  "true";
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


        $scope.goBackToProfile = function() {
            $window.location.href = 'fanProfile.html';
        };
        $scope.g = function() {
            console.log("aa");
        }
    }

})();
