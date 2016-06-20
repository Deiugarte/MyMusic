(function() {
    'use strict';
    angular
        .module('refiereApp.createAlbum')
        .controller('createAlbumCtrl', createAlbumCtrl);

    createAlbumCtrl.$inject = ['CreateAlbumSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function createAlbumCtrl(CreateAlbumSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;
        $scope.newAlbumData = {};
        $scope.newAlbumData.idUser = "11";
        $scope.newAlbumData.releaseYear = "2016";
        $scope.discID = 0;
        $scope.songs = [{}];


        // --------------AGREGAR Y QUITAR CANCIONES DEL FORM--------------------------
        $scope.addNewChoice = function() {
            var newItemNo = $scope.songs.length + 1;
            $scope.songs.push({});
        };

        $scope.removeChoice = function() {
            var lastItem = $scope.songs.length - 1;
            $scope.songs.splice(lastItem);
        };

        // -------------------CARGAR GENEROS PARA FORM ---------------------
        getGenresList();

        function getGenresList() {
            CreateAlbumSrv.getGenresList()
                .then(function(genresData) {
                    $scope.genres = genresData.data;
                })
        }

        // -------------------METODOS QUE SE LLAMAN CUANDO SE CIERRA EL MODAL CREAR ALBUM ---------------------
        $scope.ok = function() {
            console.log($scope.newAlbumData);
            console.log($scope.songs);
            $scope.newAlbumData.releaseYear = new Date($scope.newAlbumData.releaseYear);
            CreateAlbumSrv.postCreateNewAlbum($scope.newAlbumData)
                .then(function(dataAlbum) {
                    $scope.discID = dataAlbum.data.DiscId;
                    $scope.songs.forEach(function(row) {
                      row.idDisc = $scope.discID;
                        CreateAlbumSrv.postCreateNewSong(row)
                            .then(function(dataSong) {
                                console.log("se agrego cancion con exito");
                            }).catch(function(error) {
                                $window.alert("No se pudo crear la noticia, intente de nuevo.");
                            });
                    });
                })
                .catch(function(error) {
                    $window.alert("No se pudo crear el album, intente de nuevo.");
                });


        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
