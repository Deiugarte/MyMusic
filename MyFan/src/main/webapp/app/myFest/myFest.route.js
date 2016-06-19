(function() {
  'use strict';

  angular
    .module('refiereApp.myFest')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('myFest', {
        url: '/myFest',
        templateUrl: 'app/myFest/view.html',
        controller: 'myFestCtrl as vm'
      });
  }
})();
