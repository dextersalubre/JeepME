package home

interface HomeContract {
    interface View {
        fun openRouteDetail(name: String, fare: String, stops: String)
    }
    interface Presenter {
        fun onRouteClicked(routeName: String, fare: String, stops: String)
    }
}