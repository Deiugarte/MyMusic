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
    vm.searchUser=searchUser;
    vm.selectProfile=selectProfile;

    function selectProfile(data) {
      var url = 'http://localhost:9000/rest/v1/resources/searchArtist/'+data.valueSearch;
      return $http.get(url, data);
    }

    function getUserData(data) {
      var url = 'http://localhost:9000/rest/v1/resources/userdata/11';
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
    function searchUser(data) {
      var url = 'http://localhost:9000/rest/v1/resources/searchData';
      return $http.post(url, data);
    }
  }
})();
