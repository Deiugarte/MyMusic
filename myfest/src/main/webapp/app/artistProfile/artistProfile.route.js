(function() {
  'use strict';

  angular
    .module('refiereApp.artistProfile')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('artistProfile', {
        url: '/artistProfile',
        templateUrl: 'app/artistProfile/view.html',
        controller: 'artistProfileCtrl as vm'
      });
  }
})();
