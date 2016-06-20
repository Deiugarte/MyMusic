(function() {
    'use strict';
    angular
        .module('refiereApp.modalEvent')
        .controller('ModalInstanceCtrl', ModalInstanceCtrl);

    ModalInstanceCtrl.$inject = ['EventSrv', 'currentEvent', '$uibModalInstance', '$state', '$window', '$scope'];

    function ModalInstanceCtrl(EventSrv, currentEvent, $uibModalInstance, $state, $window, $scope) {
        $scope.currentEvent = currentEvent;
        $scope.eventRating = {};
        $scope.eventRating.idEvent = $scope.currentEvent.id;
        $scope.eventRating.idUserFanatic = 11;

        getEventComments();
        function getEventComments(){
          EventSrv.getEventComments($scope.currentEvent.id)
          .then(function(commentsData){
              $scope.eventComments = commentsData.data;
          });
        }

        $scope.sendRateEvent = function(){
          EventSrv.postRateEvent($scope.eventRating)
          .then(function(data){
              $scope.eventComments = commentsData.data;
          })
          .catch(function(error) {
            console.log(error);
            $window.alert('¡El usuario ya existe, intentelo con otro usuario!');
          });

        }







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
