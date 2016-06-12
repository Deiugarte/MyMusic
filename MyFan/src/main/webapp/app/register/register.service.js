(function() {
  'use strict';

  angular
    .module('refiereApp.register')
    .service('RegisterSrv', RegisterSrv);

  RegisterSrv.$inject = ['$http'];

  /* @ngInject */
  function RegisterSrv($http) {

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
