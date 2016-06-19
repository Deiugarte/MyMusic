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
    vm.getGenresData = getGenresData;
    vm.getUbicationsList = getUbicationsList;

    function postCompanyInfo(data) {
      return $http.post('https://powerful-oasis-46465.herokuapp.com/rest/v1/company/register', data);
    }

    function getUserData(data) {
      var url = 'https://powerful-oasis-46465.herokuapp.com/rest/v1/resources/userdata/'+1;
      return $http.get(url, data);
    }
    function getGenresData(data) {
      var url = 'https://powerful-oasis-46465.herokuapp.com/rest/v1/resources/genreslist';
      return $http.get(url, data);
    }
    function getUbicationsList(data) {
      var url = 'https://powerful-oasis-46465.herokuapp.com/rest/v1/resources/ubicationslist';
      return $http.get(url, data);
    }
  }
})();
