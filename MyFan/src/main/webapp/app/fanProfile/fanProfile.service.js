(function() {
  'use strict';

  angular
    .module('refiereApp.fanProfile')
    .service('FanaticSrv', FanaticSrv);

  FanaticSrv.$inject = ['$http'];

  /* @ngInject */
  function FanaticSrv($http) {
    var vm = this;
    vm.postCompanyInfo = postCompanyInfo;
    vm.getUserData = getUserData;


    function postCompanyInfo(data) {
      return $http.post('http://localhost:8000/rest/v1/company/register', data);
    }

    function getUserData(data) {
      var url = 'http://localhost:8000/rest/v1/resources/userdata/11';
      return $http.get(url, data);
    }
  }
})();
