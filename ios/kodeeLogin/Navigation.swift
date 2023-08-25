import Foundation
import SwiftUI

struct Navigation: View {
    
    @State var path = [String]()
    
    var body: some View {
        NavigationStack(path: $path) {
            NavigationLink("Welcome! Press here to navigate to Login", value: "login")
                .navigationDestination(for: String.self) { string in
                    switch(string) {
                    case "login": KodeeLoginScreen{
                        path.append("success")
                    }
                    case "success": Text("Success")
                    default:
                        EmptyView()
                    }
                }
        }
    }
}

struct NavigationView_Preview: PreviewProvider {
    static var previews: some View {
        Navigation()
    }
}
