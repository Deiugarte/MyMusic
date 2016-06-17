(function() {
  'use strict';

  angular
    .module('refiereApp.artistProfile')
    .service('ArtistSrv', ArtistSrv);

  ArtistSrv.$inject = ['$http'];

  /* @ngInject */
  function ArtistSrv($http) {

    this.postCompanyInfo = postCompanyInfo;
    this.getPlansFromServer = getPlansFromServer;

    function postCompanyInfo(data) {
      return $http.post('http://localhost:8000/rest/v1/company/register', data);
    }

    function getPlansFromServer(data) {
      return $http.get('http://localhost:8000/rest/v1/plan/all', data);
    }
  }
})();
