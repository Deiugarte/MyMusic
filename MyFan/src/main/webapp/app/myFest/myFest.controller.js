(function() {
    'use strict';
    angular
        .module('refiereApp.myFest')
        .controller('myFestCtrl', myFestCtrl);

    myFestCtrl.$inject = ['MyFestSrv', '$log', '$uibModal', '$state', '$window', '$scope'];

    function myFestCtrl(MyFestSrv, $log, $uibModal, $state, $window, $scope) {
        var vm = this;
        $scope.data = {
                   dataset0: [
                       {
                           x: "2016-05-18",
                           val_0: 5
                       },
                       {
                           x: "2016-06-12",
                           val_0: 4
                       },
                       {
                           x: "2016-07-07",
                           val_0: 10
                       },
                       {
                           x: "2016-09-18",
                           val_0: 2
                       },

                       {
                           x: "2016-12-18",
                           val_0: 7
                       }
                   ]

               };
               $scope.options = {
                   margin: {top: 15},
                   series: [{
                           axis: "y",
                           dataset: "dataset0",
                           key: "val_0",
                           color: "hsla(88, 48%, 48%, 1)",
                           type: ["line"],
                           id: "Menciones en Twitter"
                       }
                   ],
                   axes: {x: {key: "x", type: "date"}}
               };

               $scope.data.dataset0.forEach(function (row) {
                   row.x = new Date(row.x);
               });


        vm.currentEvent = {};
        vm.newUser = {};
        vm.genresList = {};
        vm.countriesList = {};
        vm.open = function(size, title, body, stars, commentsAmount) {
            vm.currentEvent.title = title;
            vm.currentEvent.body = body;
            vm.currentEvent.stars = stars;
            vm.currentEvent.commentsAmount = commentsAmount;
            console.log(vm.currentEvent);
            var modalInstance = $uibModal.open({
                animation: $scope.animationsEnabled,
                templateUrl: '/templates/modalEvent/view.html',
                controller: 'ModalInstanceCtrl',
                size: size,
                resolve: {
                    currentEvent: function() {
                        return vm.currentEvent;
                    }
                }

            });
            modalInstance.result.then(function(selectedItem) {
                $scope.selected = selectedItem;
            }, function() {
                $log.info('Modal dismissed at: ' + new Date());
            });


        };

        getUserData();

        function getUserData(data) {
            MyFestSrv.getUserData()
                .then(function(info) {
                    vm.newUser = info.data;
                })
        }

        function getGenresData(data) {
            MyFestSrv.getGenresData()
                .then(function(info) {
                    vm.genresList = info.data;
                })
        }

        function getUbicationsList() {
            MyFestSrv.getUbicationsList()
                .then(function(ubicationData) {
                    vm.countriesList = ubicationData.data;
                })
        }


        $scope.filtersInvisible = true;
        $scope.showFilters = function() {
            if ($scope.filtersInvisible) {
                $scope.filtersInvisible = false;
                getGenresData();
                getUbicationsList();
            } else {
                $scope.filtersInvisible = true;
            }

        };
    }
})();
