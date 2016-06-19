(function() {
    'use strict';
    angular
        .module('refiereApp.genresManager')
        .controller('genresManagerCtrl', genresManagerCtrl);

    genresManagerCtrl.$inject = ['GenresManagerSrv','$uibModal', '$state', '$window', '$scope'];

    function genresManagerCtrl(GenresManagerSrv, $uibModal, $state, $window, $scope) {
        var vm = this;
        vm.currentUser = {};
        vm.currentEvent = {};

})();
