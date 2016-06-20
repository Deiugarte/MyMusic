(function() {
    'use strict';

    angular
        .module('refiereApp.editFan')
        .service('EditFanSrv', EditFanSrv);

    EditFanSrv.$inject = ['$http'];

    /* @ngInject */
    function EditFanSrv($http) {
        var vm = this;
        vm.postCompanyInfo = postCompanyInfo;
        vm.postUpdateFanatic = postUpdateFanatic;
        vm.getUserData = getUserData;
        vm.getGenresList = getGenresList;
        vm.getUbicationsList = getUbicationsList;

        function postCompanyInfo(data) {
            return $http.post('http://localhost:8000/rest/v1/company/register', data);
        }

        function getUserData(data) {
            var url = 'http://localhost:8000/rest/v1/resources/userdata/11';
            return $http.get(url, data);
        }

        function getGenresList(data) {
            var url = 'http://localhost:8000/rest/v1/resources/genreslist';
            return $http.get(url, data);
        }

        function getUbicationsList(data) {
            var url = 'http://localhost:8000/rest/v1/resources/ubicationslist';
            return $http.get(url, data);
        }

        function postUpdateFanatic(data, file) {
            var jsonData = JSON.stringify(data);
            console.log(jsonData);
            var fd = new FormData();
            fd.append('file', file);
            fd.append('data', jsonData);
            var url = 'http://localhost:8000/rest/v1/userActions/modifyFanatic';
            return $http.post(url, fd, {
                transformRequest: angular.identity,
                headers: {
                    'Content-Type': undefined
                }
            });
        }

    }
})();
