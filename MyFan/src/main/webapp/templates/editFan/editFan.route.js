(function() {
  'use strict';

  angular
    .module('refiereApp.editFan')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('editFan', {
        url: '/editFan',
        templateUrl: '/templates/editFan/view.html',
        controller: 'editFanCtrl as vm'
      });
  }
})();
