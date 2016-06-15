(function() {
  'use strict';

  angular
    .module('refiereApp.register')
    .controller('RegisterCtrl', RegisterCtrl);

  RegisterCtrl.$inject = ['RegisterSrv', '$state', '$window','$scope'];

  /* @ngInject */
  function RegisterCtrl(RegisterSrv, $state, $window,$scope) {
    var vm = this;
    vm.newUserData = {};
    vm.saveNewCompany = saveNewCompany;
    vm.plans = {};
    vm.data = {
    repeatSelect: null,
    availableOptions: [
      {id: '1', name: 'Costa Rica'},
      {id: '2', name: 'Panama'},
      {id: '3', name: 'Nicaragua'}
    ],
   };
   vm.multipleDemo={};
   vm.multipleDemo.selectedPeopleSimple = [];
   vm.people = [
  { name: 'Adam' },
  { name: 'Amalie'},
  { name: 'Estefanía' },
  { name: 'Adrian' },
  { name: 'Wladimir'},
  { name: 'Samantha'},
  { name: 'Nicole', },
  { name: 'Natasha', },
  { name: 'Michael',  },
  { name: 'Nicolás',  }
];



     $scope.dateOptions = {
       showWeeks: false,
       datepickerMode:"year"
     };
     $scope.open1 = function() {
        $scope.popup1.opened = true;
      };

      $scope.popup1 = {
        opened: false
      };







    getPlans();


    function getPlans() {
      RegisterSrv.getPlansFromServer()
        .then(function(plansData){
          vm.plans = plansData.data;
        })
    }

    function saveNewCompany() {
      RegisterSrv.postCompanyInfo(vm.newCompanyData)
        .then(function(data) {
          // console.log(data.status);
          if (data.status === 200){
            $window.alert('Bienvenido ' + vm.newCompanyData.UserRequest.login + '.' );
            $state.go('app.dashboard');
          }
          else if (data.status === 400){
            $window.alert('Por favor ingrese los datos correctos.');
          }
          else if (data.status === -1){
            $window.alert('¡El usuario ya existe!');
          }
          else{
            $window.alert('Ocurrió un error con la conexión');
          }
        })
        .catch(function(error) {
          console.log(error);
          $window.alert('¡El usuario ya existe, intentelo con otro usuario!');
        });
    }
  }

})();
