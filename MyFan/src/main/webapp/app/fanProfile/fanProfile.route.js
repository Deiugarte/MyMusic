(function() {
  'use strict';

  angular
    .module('refiereApp.fanProfile')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('fanProfile', {
        url: '/fanProfile',
        templateUrl: 'app/fanProfile/view.html',
        controller: 'fanProfileCtrl as vm'
      });
  }
})();
