(function() {
  'use strict';

  angular
    .module('refiereApp.register')
    .service('RegisterSrv', RegisterSrv);

  RegisterSrv.$inject = ['$http'];

  /* @ngInject */
  function RegisterSrv($http) {
    var vm=this;
    vm.postCompanyInfo = postCompanyInfo;
    vm.getPlansFromServer = getPlansFromServer;
    vm.postNewFanatic= postNewFanatic;
    vm.getGenresList = getGenresList;

    function postCompanyInfo(data) {
      return $http.post('http://localhost:8000/rest/v1/company/register', data);
    }

    function getGenresList(data) {
      var url = 'http://localhost:8000/rest/v1/resources/genreslist';
      return $http.get(url, data);
    }

    function postNewFanatic(data,file){
      var jsonData = JSON.stringify(data);
      console.log(jsonData);
      var fd = new FormData();
        fd.append('file', file);
        fd.append('data',jsonData);
     var url = 'http://localhost:8000/rest/v1/register/fanatic';
     return $http.post(url, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });

    }



    function getPlansFromServer(data) {
      return $http.get('http://localhost:8000/rest/v1/plan/all', data);
    }
  }
})();
