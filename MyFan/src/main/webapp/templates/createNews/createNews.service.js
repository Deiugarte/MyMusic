(function() {
  'use strict';

  angular
    .module('refiereApp.createNews')
    .service('CreateNewsSrv', CreateNewsSrv);

  CreateNewsSrv.$inject = ['$http'];

  /* @ngInject */
  function CreateNewsSrv($http) {
    var vm = this;
    vm.postCreateNewNews = postCreateNewNews;
    vm.getUserData = getUserData;


    function postCreateNewNews(data) {
      var url = 'http://localhost:8000/rest/v1/news/add';
      return $http.post(url, data);
    }

    function getUserData(data) {
      var url = 'http://localhost:8000/rest/v1/resources/userdata/11';
      return $http.get(url, data);
    }



  }
})();
