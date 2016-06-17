(function() {
    'use strict';
    angular
        .module('refiereApp.modalEvent')
        .controller('ModalInstanceCtrl', ModalInstanceCtrl);

    ModalInstanceCtrl.$inject = ['EventSrv', 'currentEvent', '$uibModalInstance', '$state', '$window', '$scope'];

    function ModalInstanceCtrl(EventSrv, currentEvent, $uibModalInstance, $state, $window, $scope) {
        $scope.currentEvent = currentEvent;
        $scope.selected = {
            currentEvent: $scope.currentEvent[0]
        };

        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentEvent);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
