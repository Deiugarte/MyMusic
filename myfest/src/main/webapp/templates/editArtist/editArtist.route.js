(function() {
  'use strict';

  angular
    .module('refiereApp.editArtist')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('editArtist', {
        url: '/editArtist',
        templateUrl: '/templates/editArtist/view.html',
        controller: 'editArtistCtrl as vm'
      });
  }
})();
