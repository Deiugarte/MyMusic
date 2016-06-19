(function() {
    'use strict';
    angular
        .module('refiereApp.editFan')
        .controller('editFanCtrl', editFanCtrl);

    editFanCtrl.$inject = ['EditFanSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function editFanCtrl(EditFanSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;
        $scope.selected = {
            currentEvent: $scope.currentUser[0]
        };

        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentUser);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
