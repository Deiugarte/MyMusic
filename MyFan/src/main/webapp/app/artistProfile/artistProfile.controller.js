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
                $scope.selected = selectedItem;
            }, function() {
                $log.info('Modal dismissed at: ' + new Date());
            });
        };


        vm.artistProfile = {
            name: 'Bob Maryley',
            followers: 2001,
            members: [
                "Solista"
            ],
            sex: 'Masculino',
            genres: ['Dub',
                'Reggae',
                'Ska'
            ],
            country: 'Costa Rica',
            year: 1980,
            stars: 5,
        };
        vm.currentUser ={
          type: "artist",
          id: "101",
          userName: "Alejandro22",
          name: "Alejandro",
        }
        vm.timeline = {
            publications: [{
                type: "noticia",
                title: "Universal Music comercializarálos Beatles en España",
                body: "Universal Music Spain, coincidmatos DVD y Blu-ray, ha llegado a un acuerdo con Apple Corp",
                date: "20/04/2015"
            }, {
                type: "noticia",
                title: "Se murió michael jackson",
                body: "GG legítimo",
                date: "12/03/2009"
            }, {
                type: "evento",
                title: "Ky-Mani Marley engalanará el Reggae Festival",
                body: "Un dia de estos tocas Ki MA ni marly",
                date: "25/12/2011",
                stars: 3,
                commentsAmount: 100
            }, {
                type: "evento",
                title: "Ky-Mani Marley engalanará el Reggae Festival",
                body: "Un dia de estos tocas Ki MA ni marly",
                date: "25/12/2011",
                stars: 5,
                commentsAmount: 20
            }]
        };

        vm.discography = {
            albums: [{
                title: "Legend",
                description: "Legend es un álbum de grandes éxitos de Bob Marley and the Wailers publicado el 8 de mayo de 1984 a través de Island Records.",
                albumImage: "",
                genre: "Reggae",
                commentsAmount: 24,
                songsAmount: 10,
                stars: 3,
                recordLabel: "Island Records",
                year: 1986,
                songs: [{
                    name: "Is This Love",
                    duration: "3:52",
                    version: "normal",
                    type: "Estudio",
                    video: "link"
                }, {
                    name: "No Woman, No Cry",
                    duration: "7:10",
                    version: "normal",
                    type: "En vivo",
                    video: "link"
                }, {
                    name: "Could you be loved",
                    duration: "3:52",
                    version: "limitada",
                    type: "En vivo",
                    video: "Sí"
                }, ]
            }, {
                title: "Uprising",
                description: "Uprising is a 1980 reggae album by Bob Marley and the Wailers. Marley died the following year.",
                albumImage: "",
                genre: "Reggae",
                commentsAmount: 48,
                songsAmount: 12,
                stars: 5,
                recordLabel: "Tuff Gong/Island",
                year: 1980,
                songs: [{
                    name: "Coming in from the Cold",
                    duration: "3:40",
                    version: "normal",
                    type: "En vivo",
                    video: "No"
                }, {
                    name: "We and Dem",
                    duration: "2:40",
                    version: "normal",
                    type: "En vivo",
                    video: "Sí"
                }, {
                    name: "Real Situation",
                    duration: "3:08",
                    version: "limitada",
                    type: "Estudio",
                    video: "No"
                }, ]
            }]
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
