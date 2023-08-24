import SwiftUI

struct ContentView: View {
    
    @State var email: String = ""
    @State var password: String = ""
    
    var body: some View {
        VStack {
            ZStack(
                alignment: .center
            ) {
                KodeeLogin(email: $email, password: $password)
            }.onTapGesture {
                print("we doing something")
                // Hide keyboard on tap outside of TextField
                UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
