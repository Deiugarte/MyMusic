(function() {
  'use strict';

  angular
    .module('refiereApp.myFest')
    .service('MyFestSrv', MyFestSrv);

  MyFestSrv.$inject = ['$http'];

  /* @ngInject */
  function MyFestSrv($http) {
    var vm = this;
    vm.getUserData = getUserData;
    vm.getGenresData = getGenresData;
    vm.getUbicationsList = getUbicationsList;

    function getUserData(data) {
      var url = 'http://localhost:8000/rest/v1/resources/userdata/11';
      return $http.get(url, data);
    }
    function getGenresData(data) {
      var url = 'http://localhost:9000/rest/v1/resources/genreslist';
      return $http.get(url, data);
    }
    function getUbicationsList(data) {
      var url = 'http://localhost:9000/rest/v1/resources/ubicationslist';
      return $http.get(url, data);
    }
  }
})();
