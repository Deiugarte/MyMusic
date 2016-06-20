(function() {
    'use strict';
    angular
        .module('refiereApp.modalEvent')
        .controller('modalAlbumCtrl', modalAlbumCtrl);

    modalAlbumCtrl.$inject = ['AlbumSrv', 'currentAlbumInfo', '$uibModalInstance', '$state', '$window', '$scope'];

    function modalAlbumCtrl(AlbumSrv, currentAlbumInfo, $uibModalInstance, $state, $window, $scope) {
        $scope.currentAlbumInfo = currentAlbumInfo;
        $scope.albumCommentRating = "";
        $scope.albumRating.idDisc = $scope.currentAlbumInfo.idDisc;
        $scope.albumRating.idUserFanatic = 12;

        getAlbumComments();
        function getAlbumComments(){
          AlbumSrv.getAlbumComments($scope.currentAlbumInfo)
          .then(function(commentsData){
              $scope.albumComments = commentsData.data;
              console.log(commentsData.data);
              console.log("arriba comments de album, aba");
          });
        }

        $scope.sendRateAlbum = function(){
          console.log($scope.albumRating);
          AlbumSrv.postRateAlbum($scope.albumRating)
          .then(function(data){
            console.log(data);
          })
          .catch(function(error) {
            console.log(error);
            $window.alert('No se pudo calificar el disco :( ');
          });

        }


        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentEvent);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
