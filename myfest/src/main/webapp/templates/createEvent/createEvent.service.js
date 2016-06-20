(function() {
  'use strict';

  angular
    .module('refiereApp.createEvent')
    .service('CreateEventSrv', CreateEventSrv);

  CreateEventSrv.$inject = ['$http'];

  /* @ngInject */
  function CreateEventSrv($http) {
    var vm = this;
    vm.postCreateNewEvent = postCreateNewEvent;
    vm.getUserData = getUserData;
    vm.getUbicationsList = getUbicationsList;

    
    function postCreateNewEvent(data) {
      var url = 'http://localhost:8000/rest/v1/events/add';
      return $http.post(url, data);
    }



    function getUserData(data) {
      var url = 'http://localhost:8000/rest/v1/resources/userdata/11';
      return $http.get(url, data);
    }

    function getUbicationsList(data) {
      var url = 'http://localhost:8000/rest/v1/resources/ubicationslist';
      return $http.get(url, data);
    }
  }
})();
