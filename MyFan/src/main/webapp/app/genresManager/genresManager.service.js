(function() {
  'use strict';

  angular
    .module('refiereApp.genresManager')
    .service('GenresManagerSrv', GenresManagerSrv);

  GenresManagerSrv.$inject = ['$http'];

  /* @ngInject */
  function GenresManagerSrv($http) {

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
