(function() {
  'use strict';

  angular
    .module('refiereApp.modalEvent')
    .service('EventSrv', EventSrv);

  EventSrv.$inject = ['$http'];

  /* @ngInject */
  function EventSrv($http) {
    var vm = this;
    vm.getEventComments = getEventComments;
    vm.postRateEvent = postRateEvent;

    function getEventComments(data){
      var url = 'http://localhost:8000/rest/v1/comments/getEventComments/' + data.id;
      return $http.get(url, data);
    }

    function postRateEvent(data){
      var url = 'http://localhost:8000/rest/calificate/event';
      return $http.post(url, data);
    }

  }
})();
