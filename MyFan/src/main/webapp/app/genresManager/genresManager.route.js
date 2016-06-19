(function() {
  'use strict';

  angular
    .module('refiereApp.genresManager')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('genresManager', {
        url: '/genresManager',
        templateUrl: 'app/genresManager/view.html',
        controller: 'genresManagerCtrl as vm'
      });
  }
})();
