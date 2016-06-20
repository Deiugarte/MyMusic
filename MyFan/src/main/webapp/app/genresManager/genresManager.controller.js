(function() {
    'use strict';
    angular
        .module('refiereApp.genresManager')
        .controller('genresManagerCtrl', genresManagerCtrl);

    genresManagerCtrl.$inject = ['GenresManagerSrv','$uibModal', '$state', '$window', '$scope'];

    function genresManagerCtrl(GenresManagerSrv, $uibModal, $state, $window, $scope) {
        var vm = this;
        vm.newGenre = {};
        vm.genresList = {};

        vm.agregarGenero = function () {

          GenresManagerSrv.postAddNewGenres(vm.newGenre)
          .then(function(data){
              getGenresList();
              vm.newGenre.musicalGenre = "";
              console.log("estoy agregando nuevo genero");
          }).catch(function(error) {
              console.log("Hubo un error al agregar género");
          });
        }
        getGenresList();
        function getGenresList() {
          GenresManagerSrv.getGenresList()
            .then(function(genresData){
              vm.genresList = genresData.data;
            })
        }


      }

})();
