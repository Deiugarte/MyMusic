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
    vm.getDiscography = getDiscography;
    vm.getArtistComments = getArtistComments;
    vm.postRateArtist = postRateArtist;
    vm.postFollowStatus = postFollowStatus;
    vm.postUnfollowStatus = postUnfollowStatus;

    function getArtistComments(data){
      var url = 'http://localhost:8000/rest/v1/comments/getArtistComments/' + data.idArtist;
      return $http.get(url, data);
    }

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

    function getDiscography(data) {
      var url = 'http://localhost:8000/rest/v1/disc/discography/'+ data.idUser;
      return $http.get(url, data);
    }

    function postRateArtist(data){
      var url = 'http://localhost:8000/rest/calificate/artist';
      return $http.post(url, data);
    }

    function postFollowStatus(data){
      var url = 'http://localhost:8000/rest/v1/userActions/followArtist';
      return $http.post(url, data);
    }

    function postUnfollowStatus(data){
      var url = 'http://localhost:8000/rest/v1/userActions/unfollowArtist';
      return $http.post(url, data);
    }

  }
})();
