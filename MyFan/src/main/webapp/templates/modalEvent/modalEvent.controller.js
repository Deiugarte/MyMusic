(function() {
    'use strict';
    angular
        .module('refiereApp.modalEvent')
        .controller('ModalInstanceCtrl', ModalInstanceCtrl);

    ModalInstanceCtrl.$inject = ['EventSrv', 'currentEvent', '$uibModalInstance', '$state', '$window', '$scope','$log'];

    function ModalInstanceCtrl(EventSrv, currentEvent, $uibModalInstance, $state, $window, $scope,$log) {
        $scope.currentEvent = currentEvent;
        $scope.eventRating = {};
        $scope.eventRating.idEvent = $scope.currentEvent.id;
        $scope.eventRating.idUserFanatic = $cookies.getObject('userInfo').UserId;

        getEventComments();
        function getEventComments(){
          EventSrv.getEventComments($scope.currentEvent)
          .then(function(commentsData){
              $scope.eventComments = commentsData.data;
              console.log(commentsData.data);
              console.log("este");
              console.log($scope.eventComments);
          });
        }

        $scope.sendRateEvent = function(){
          console.log($scope.eventRating);
          EventSrv.postRateEvent($scope.eventRating)
          .then(function(data){
            console.log(data);
          })
          .catch(function(error) {
            console.log(error);
            $window.alert('No se pudo calificar el evento :(');
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
