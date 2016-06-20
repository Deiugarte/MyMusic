(function() {
  'use strict';

  angular
    .module('refiereApp.createAlbum')
    .service('CreateAlbumSrv', CreateAlbumSrv);

  CreateAlbumSrv.$inject = ['$http'];

  /* @ngInject */
  function CreateAlbumSrv($http) {
    var vm = this;
    vm.postCreateNewAlbum = postCreateNewAlbum;
    vm.postCreateNewSong = postCreateNewSong;
    vm.getGenresList = getGenresList;

    function postCreateNewAlbum(data) {
      var url = 'http://localhost:8000/rest/v1/disc/addDisc';
      return $http.post(url, data);
    }

    function postCreateNewSong(data) {
      var url = 'http://localhost:8000/rest/v1/disc/addSong';
      return $http.post(url, data);
    }

    function getGenresList(data) {
      var url = 'http://localhost:8000/rest/v1/resources/genreslist';
      return $http.get(url, data);
    }

  }
})();
