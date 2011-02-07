(ns leiningen.fig "fig"
    (:use [lancet :only [mkdir copy fileset chmod exec]]
          [leiningen.deps :only [deps]]
          [robert.hooke]))

(defn fig [project]
  (exec { :command (org.apache.tools.ant.types.Commandline. "fig -u")}))

(defn fig-hook [task & args]
  (apply task args)
  (apply fig args))

(add-hook #'leiningen.deps/deps fig-hook)


