(function() {
  'use strict';

  angular
    .module('refiereApp.register')
    .controller('RegisterCtrl', RegisterCtrl);

  RegisterCtrl.$inject = ['RegisterSrv', '$state', '$window','$scope','Upload'];

  /* @ngInject */
  function RegisterCtrl(RegisterSrv, $state, $window,$scope,Upload) {
    var vm = this;
    vm.newUserData = {};
    vm.newUserData.musicalGenres = [];
    vm.saveNewCompany = saveNewCompany;
    vm.registerNewUser = registerNewUser;
    vm.plans = {};
    vm.data = {
    repeatSelect: null,
    availableOptions: [
      {id: '1', name: 'Costa Rica'},
      {id: '2', name: 'Panama'},
      {id: '3', name: 'Nicaragua'}
    ],
   };
   vm.people = [
  { name: 'Rock' },
  { name: 'Pop'},
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
    getGenresList();
    function getGenresList() {
      RegisterSrv.getGenresList()
        .then(function(genresData){
          vm.people = genresData.data;
        })
    }

    function getPlans() {
      RegisterSrv.getPlansFromServer()
        .then(function(plansData){
          vm.plans = plansData.data;
        })
    }
    function registerNewUser(){
      RegisterSrv.postNewFanatic(vm.newUserData,vm.picfile)
        .then(function(data) {
          // console.log(data.status);
          if (data.status === 200){
            $window.alert('Bienvenido' );
            $state.go('app.dashboard');
          }
          else if (data.status === 404){
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
