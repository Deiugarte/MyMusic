(function() {
  'use strict';

  angular
    .module('refiereApp')
    .config(setRoutes);

  function setRoutes($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/login');

    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'app/login/view.html'
      });
  }
})();
