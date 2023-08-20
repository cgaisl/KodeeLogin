//
//  ContentView.swift
//  kodeeLogin
//
//  Created by Christian Gaisl on 20.08.23.
//

import SwiftUI

struct ContentView: View {
    
    @State var email: String = ""
    @State var password: String = ""
    
    var body: some View {
        VStack {
            KodeeLogin(email: $email, password: $password)
            
            HStack {
                Text("Email: ")
                TextField(email, text: $email)
            }
            HStack {
                Text("Password: ")
                TextField(password, text: $password)
            }
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
