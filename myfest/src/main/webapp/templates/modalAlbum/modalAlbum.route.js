(function() {
  'use strict';

  angular
    .module('refiereApp.modalAlbum')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('modalAlbum', {
        url: '/modalAlbum',
        templateUrl: '/templates/modalAlbum/view.html',
        controller: 'modalAlbumCtrl as vm'
      });
  }
})();
