(function() {
    'use strict';
    angular
        .module('refiereApp.createEvent')
        .controller('createEventCtrl', createEventCtrl);

    createEventCtrl.$inject = ['CreateEventSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function createEventCtrl(CreateEventSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;
        $scope.isCalendarOpen = false;
        $scope.selected = {
            currentUser: $scope.currentUser[0]
        };

        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentUser);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
