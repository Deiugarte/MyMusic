(function() {
  'use strict';

  angular
    .module('refiereApp.artistProfile')
    .service('ArtistSrv', ArtistSrv);

  ArtistSrv.$inject = ['$http'];

  /* @ngInject */
  function ArtistSrv($http) {
    var vm= this;
    vm.getTimelineNews = getTimelineNews;
    vm.getTimelineEvents = getTimelineEvents;
    vm.getUserData=getUserData;
    function getTimelineNews(data){
      var url = 'http://localhost:8000/rest/v1/news/getRecent'
      return $http.post(url,data);
    }

    function getTimelineEvents(data){
      var url = 'http://localhost:8000/rest/v1/events/getRecent'
      return $http.post(url,data);
    }

    function getUserData(data) {
      var url = 'http://localhost:8000/rest/v1/resources/artistData/'+data.UserId;
      return $http.get(url, data);
    }
  }
})();
