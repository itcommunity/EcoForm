angular.module('myApp', ['ngAnimate', 'ui.bootstrap']);
angular.module('myApp').controller('customersCtrl', function($scope,$http,$uibModal) {
		$http.get("/group/getAll").
			then(function(response) {
				$scope.myData = response.data;
			}
		);
		
		$scope.filterPeople = function() {								
			var dataObj = {
					"skills": $('#dropdownMenu1').text(),
					"joinUmka": $('#dropdownMenu2').text(),
					"timeWithUs": $('#dropdownMenu3').text(),
					"members": $('#dropdownMenu4').text()

			};	
			var res = $http.post('/group/getAllByParams', dataObj);

			res.success(function(data, status, headers, config) {
				$scope.myData = data;
			});
			res.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});	
		
		};
		
	
	  $scope.openDetails = function (items) {
		$scope.items = items;
		var modalInstance = $uibModal.open({
		  animation: $scope.animationsEnabled,
		  templateUrl: 'myModalContent.html',
		  controller: 'ModalInstanceCtrl',
		  size: 'lg',
		  resolve: {
			items: function () {
			  return $scope.items;
			}
		  }
		});

		
	  };

	  $scope.toggleAnimation = function () {
		$scope.animationsEnabled = !$scope.animationsEnabled;
	  };
		
})

angular.module('myApp').controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, items) {

  $scope.items = items;

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };
});


