(function() {
  'use strict';

  angular
    .module('refiereApp.createEvent')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('createEvent', {
        url: '/createEvent',
        templateUrl: '/templates/createEvent/view.html',
        controller: 'createEventCtrl as vm'
      });
  }
})();
