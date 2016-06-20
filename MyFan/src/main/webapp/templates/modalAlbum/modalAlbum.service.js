(function() {
  'use strict';

  angular
    .module('refiereApp.modalAlbum')
    .service('AlbumSrv', AlbumSrv);

  AlbumSrv.$inject = ['$http'];

  /* @ngInject */
  function AlbumSrv($http) {
    var vm = this;
    vm.getAlbumComments = getAlbumComments;
    vm.postRateDisc = postRateDisc;

    function getAlbumComments(data){
      var url = 'http://localhost:8000/rest/v1/comments/getDiscComments/' + data.idDisc;
      return $http.get(url, data);
    }

    function postRateDisc(data){
      var url = 'http://localhost:8000/rest/calificate/disc';
      return $http.post(url, data);
    }
  }
})();
