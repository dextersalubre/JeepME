package home

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {
    override fun onRouteClicked(routeName: String, fare: String, stops: String) {
        view.openRouteDetail(routeName, fare, stops)
    }
}