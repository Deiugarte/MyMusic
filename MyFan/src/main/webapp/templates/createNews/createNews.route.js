(function() {
  'use strict';

  angular
    .module('refiereApp.createNews')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('createNews', {
        url: '/createNews',
        templateUrl: '/templates/createNews/view.html',
        controller: 'createNewsCtrl as vm'
      });
  }
})();
