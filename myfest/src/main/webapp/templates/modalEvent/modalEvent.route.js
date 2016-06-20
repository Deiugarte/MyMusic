(function() {
  'use strict';

  angular
    .module('refiereApp.modalEvent')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('modalEvent', {
        url: '/modalEvent',
        templateUrl: '/templates/modalEvent/view.html',
        controller: 'ModalInstanceCtrl as vm'
      });
  }
})();
