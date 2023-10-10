package Frtnt;

import java.util.ArrayList;
import java.util.List;

public class InModule {
  static List<Character> installedModule = new ArrayList<>();

  public static void main(String[] args){
      Module A = new Module('A');
      A.dependantModule = new char[2];
      A.dependantModule[0] = 'B';
      A.dependantModule[1] = 'C';

      Module B = new Module('B');
      B.dependantModule = new char[2];
      B.dependantModule[0] = 'C';
      B.dependantModule[1] = 'D';

     Module C = new Module('C');
     C.dependantModule = new char[1];
     C.dependantModule[0] = 'D';

    List<Module> lst = new ArrayList<>();
    lst.add(A);
    lst.add(B);
    lst.add(C);

    installModule(lst);

  }

  public static void installModule(List<Module> modules){
    //let's find independent module
    List<Module> modulesToBeInstall = new ArrayList<>();
    for(Module m : modules){
      if(null == m.dependantModule || m.dependantModule.length == 0){
        installedModule.add(m.name);
      }else {
        modulesToBeInstall.add(m);
      }
    }

    int count = modulesToBeInstall.size();
    int prev = count;
    while (count > 0){
      for(Module m : modulesToBeInstall){
        int requiredModuleCount = m.dependantModule.length;
        for(char n : m.dependantModule){
          if(installedModule.contains(n)){
            requiredModuleCount--;
          }
        }
        if(requiredModuleCount == 0){
          System.out.println("New Module installed"+m.name);
          installedModule.add(m.name);
          count--;
        }
      }
      if(count == prev){
        System.out.println("No modules further to be installed");
        break;
      }
    }

  }

  static class Module{
    char name;
    char[] dependantModule;
    public Module(char ch){
      this.name = ch;
    }
  }
}


