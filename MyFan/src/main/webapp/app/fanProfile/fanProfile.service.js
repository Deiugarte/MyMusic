(function() {
  'use strict';

  angular
    .module('refiereApp.fanProfile')
    .service('FanaticSrv', FanaticSrv);

  FanaticSrv.$inject = ['$http','$log'];

  /* @ngInject */
  function FanaticSrv($http,$log) {
    var vm = this;
    vm.getUserData = getUserData;
    vm.getGenresData = getGenresData;
    vm.getUbicationsList = getUbicationsList;
    vm.getTimelineNews = getTimelineNews;
    vm.getTimelineEvents = getTimelineEvents;

    function getTimelineNews(data){
      var url = 'http://localhost:8000/rest/v1/news/getRecent'
      return $http.post(url,data);
    }

    function getTimelineEvents(data){
      var url = 'http://localhost:8000/rest/v1/events/getRecent'
      return $http.post(url,data);
    }


    function getUserData(data) {
      var url = 'http://localhost:8000/rest/v1/resources/userdata/'+data.UserId;
      return $http.get(url, data);
    }
    function getGenresData(data) {
      var url = 'http://localhost:8000/rest/v1/resources/genreslist';
      return $http.get(url, data);
    }
    function getUbicationsList(data) {
      var url = 'http://localhost:8000/rest/v1/resources/ubicationslist';
      return $http.get(url, data);
    }
  }
})();
