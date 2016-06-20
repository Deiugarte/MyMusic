(function() {
  'use strict';

  angular
    .module('refiereApp.login')
    .controller('LoginCtrl', LoginCtrl);

  LoginCtrl.$inject = ['$state', 'LoginSrv', '$window','$log', 'UserDataService','$cookies','$cookieStore'];

  /* @ngInject */
  function LoginCtrl($state, LoginSrv, $window,$log,UserDataService,$cookies,$cookieStore) {
    var vm = this;

    vm.loginData = {};
    vm.login = login;

    function login() {

      LoginSrv.verifyUser(vm.loginData)
        .then(function(data) {

          var userInfo = data.data;
          UserDataService.setUserInfoData(userInfo);

          if (data.status === 200){
            if(userInfo.RoleIdentifier=='fanatic'){
              $state.go('fanProfile');
            }
            if(userInfo.RoleIdentifier=='artist'){
              $state.go('artistProfile');
            }
            if(userInfo.RoleIdentifier=='admin'){
              $state.go('adminProfile');
            }
          }

        })
        .catch(function(error) {
          $window.alert('Por favor ingrese los datos correctos.');
        });
    }
  }

})();
