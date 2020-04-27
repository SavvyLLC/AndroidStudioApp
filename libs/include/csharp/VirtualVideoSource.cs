// DO NOT EDIT! This is an autogenerated file. All changes will be
// overwritten!

//	Copyright (c) 2016 Vidyo, Inc. All rights reserved.


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.Runtime.InteropServices;

namespace VidyoClient
{
	public class VirtualVideoSource: IDisposable {
		private bool disposed = false; 
#if __IOS__
		const string importLib = "__Internal";
#else
		const string importLib = "libVidyoClient";
#endif
		private IntPtr objPtr; // opaque VidyoVirtualVideoSource reference.
		public IntPtr GetObjectPtr(){
			return objPtr;
		}
		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern ulong VidyoVirtualVideoSourceAddToLocalRendererNative(IntPtr s, IntPtr renderer);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceAddToRemoteRendererNative(IntPtr s, IntPtr remoteRenderer);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoVirtualVideoSourceClearConstraintsNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoVirtualVideoSourceConstructNative(IntPtr endpoint, [MarshalAs(UnmanagedType.I4)]VirtualVideoSourceType type, IntPtr id, IntPtr name);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoVirtualVideoSourceConstructCopyNative(IntPtr other);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoVirtualVideoSourceDestructNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern ulong VidyoVirtualVideoSourceGetCurrentEncodeFrameIntervalNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoVirtualVideoSourceGetIdNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I4)]
		private static extern MediaFormat VidyoVirtualVideoSourceGetMediaTypeNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoVirtualVideoSourceGetNameNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoVirtualVideoSourceGetPreviewLabelNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I4)]
		private static extern VirtualVideoSourceType VidyoVirtualVideoSourceGetTypeNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceIsPreviewOnNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceIsSelectedNative(IntPtr s);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoVirtualVideoSourceOnFrameNative(IntPtr s, IntPtr videoFrame, [MarshalAs(UnmanagedType.I4)]MediaFormat mediaFormat);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceRegisterEventListenerNative(IntPtr s, StartCallback onStart, ReconfigureCallback onReconfigure, StopCallback onStop, ExternalMediaBufferReleaseCallback onBufferRelease);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceRemoveFromLocalRendererNative(IntPtr s, IntPtr renderer);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceRemoveFromRemoteRendererNative(IntPtr s, IntPtr remoteRenderer);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceSendFrameWithExternalDataNative(IntPtr s, [MarshalAs(UnmanagedType.I4)]MediaFormat format, IntPtr buffer, ulong size, ulong width, ulong height);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceSetBoundsConstraintsNative(IntPtr s, ulong maxFrameInterval, ulong minFrameInterval, uint maxWidth, uint minWidth, uint maxHeight, uint minHeight);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceSetDiscreteConstraintsNative(IntPtr s, ulong maxFrameInterval, ulong minFrameInterval, uint width, uint height);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceSetLowLatencyProfileNative(IntPtr s, Boolean profile);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceSetMinFrameIntervalNative(IntPtr s, ulong frameInterval);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceSetPreviewLabelNative(IntPtr s, IntPtr previewLabel);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		[return: MarshalAs(UnmanagedType.I1)]
		private static extern Boolean VidyoVirtualVideoSourceSetStreamParametersInLocalRendererNative(IntPtr s, IntPtr localRenderer, uint width, uint height, ulong frameInterval);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		public static extern IntPtr VidyoVirtualVideoSourceGetUserDataNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		public static extern void VidyoVirtualVideoSourceSetUserDataNative(IntPtr obj, IntPtr userData);

		[UnmanagedFunctionPointer(CallingConvention.Cdecl)]
		private delegate void ExternalMediaBufferReleaseCallback(IntPtr s, IntPtr buffer, ulong size, ulong userData);
		private ExternalMediaBufferReleaseCallback _mExternalMediaBufferReleaseCallback;
		[UnmanagedFunctionPointer(CallingConvention.Cdecl)]
		private delegate void ReconfigureCallback(IntPtr s, ulong frameInterval, MediaFormat mediaFormat, ulong userData);
		private ReconfigureCallback _mReconfigureCallback;
		[UnmanagedFunctionPointer(CallingConvention.Cdecl)]
		private delegate void StartCallback(IntPtr s, ulong frameInterval, MediaFormat mediaFormat, ulong userData);
		private StartCallback _mStartCallback;
		[UnmanagedFunctionPointer(CallingConvention.Cdecl)]
		private delegate void StopCallback(IntPtr s, ulong userData);
		private StopCallback _mStopCallback;
		public enum VirtualVideoSourceType{
			VirtualvideosourcetypeSHARE,
			VirtualvideosourcetypeCAMERA
		}
		public interface IRegisterEventListener{

			void StartCallback(ulong frameInterval, MediaFormat mediaFormat, ulong userData);
			void ReconfigureCallback(ulong frameInterval, MediaFormat mediaFormat, ulong userData);
			void StopCallback(ulong userData);
			void ExternalMediaBufferReleaseCallback(byte[] buffer, ulong size, ulong userData);
		}
		private IRegisterEventListener _mIRegisterEventListener;
		public VirtualVideoSource(Endpoint endpoint, VirtualVideoSourceType type, String id, String name){

			IntPtr nId = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(id ?? string.Empty);
			IntPtr nName = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(name ?? string.Empty);
			objPtr = VidyoVirtualVideoSourceConstructNative((endpoint != null) ? endpoint.GetObjectPtr():IntPtr.Zero, type, nId, nName);
			Marshal.FreeHGlobal(nName);
			Marshal.FreeHGlobal(nId);
			VidyoVirtualVideoSourceSetUserDataNative(objPtr, GCHandle.ToIntPtr(GCHandle.Alloc(this, GCHandleType.Weak)));
		}
		public VirtualVideoSource(IntPtr other){
			objPtr = VidyoVirtualVideoSourceConstructCopyNative(other);
			VidyoVirtualVideoSourceSetUserDataNative(objPtr, GCHandle.ToIntPtr(GCHandle.Alloc(this, GCHandleType.Weak)));
		}
		~VirtualVideoSource(){
			Dispose(false);
		}
		public void Dispose(){
			Dispose(true);
			GC.SuppressFinalize(this);
		}

		public void Dispose(bool disposing){
			if(!disposed){
				if(objPtr != IntPtr.Zero){
					VidyoVirtualVideoSourceSetUserDataNative(objPtr, IntPtr.Zero);
					VidyoVirtualVideoSourceDestructNative(objPtr);
				}
				disposed = true;
			}
		}

		public ulong AddToLocalRenderer(LocalRenderer renderer){

			ulong ret = VidyoVirtualVideoSourceAddToLocalRendererNative(objPtr, (renderer != null) ? renderer.GetObjectPtr():IntPtr.Zero);

			return ret;
		}
		public Boolean AddToRemoteRenderer(RemoteRenderer remoteRenderer){

			Boolean ret = VidyoVirtualVideoSourceAddToRemoteRendererNative(objPtr, (remoteRenderer != null) ? remoteRenderer.GetObjectPtr():IntPtr.Zero);

			return ret;
		}
		public void ClearConstraints(){

			VidyoVirtualVideoSourceClearConstraintsNative(objPtr);
		}
		public ulong GetCurrentEncodeFrameInterval(){

			ulong ret = VidyoVirtualVideoSourceGetCurrentEncodeFrameIntervalNative(objPtr);

			return ret;
		}
		public String GetId(){

			IntPtr ret = VidyoVirtualVideoSourceGetIdNative(objPtr);

			return (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(ret);
		}
		public MediaFormat GetMediaType(){

			MediaFormat ret = VidyoVirtualVideoSourceGetMediaTypeNative(objPtr);

			return ret;
		}
		public String GetName(){

			IntPtr ret = VidyoVirtualVideoSourceGetNameNative(objPtr);

			return (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(ret);
		}
		public String GetPreviewLabel(){

			IntPtr ret = VidyoVirtualVideoSourceGetPreviewLabelNative(objPtr);

			return (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(ret);
		}
		public VirtualVideoSourceType GetType(){

			VirtualVideoSourceType ret = VidyoVirtualVideoSourceGetTypeNative(objPtr);

			return ret;
		}
		public Boolean IsPreviewOn(){

			Boolean ret = VidyoVirtualVideoSourceIsPreviewOnNative(objPtr);

			return ret;
		}
		public Boolean IsSelected(){

			Boolean ret = VidyoVirtualVideoSourceIsSelectedNative(objPtr);

			return ret;
		}
		public void OnFrame(VideoFrame videoFrame, MediaFormat mediaFormat){

			VidyoVirtualVideoSourceOnFrameNative(objPtr, (videoFrame != null) ? videoFrame.GetObjectPtr():IntPtr.Zero, mediaFormat);
		}
		public Boolean RegisterEventListener(IRegisterEventListener _iIRegisterEventListener){
			_mIRegisterEventListener = _iIRegisterEventListener;
			_mStartCallback = StartCallbackDelegate;
			_mReconfigureCallback = ReconfigureCallbackDelegate;
			_mStopCallback = StopCallbackDelegate;
			_mExternalMediaBufferReleaseCallback = ExternalMediaBufferReleaseCallbackDelegate;

			Boolean ret = VidyoVirtualVideoSourceRegisterEventListenerNative(objPtr, _mStartCallback, _mReconfigureCallback, _mStopCallback, _mExternalMediaBufferReleaseCallback);

			return ret;
		}
		public Boolean RemoveFromLocalRenderer(LocalRenderer renderer){

			Boolean ret = VidyoVirtualVideoSourceRemoveFromLocalRendererNative(objPtr, (renderer != null) ? renderer.GetObjectPtr():IntPtr.Zero);

			return ret;
		}
		public Boolean RemoveFromRemoteRenderer(RemoteRenderer remoteRenderer){

			Boolean ret = VidyoVirtualVideoSourceRemoveFromRemoteRendererNative(objPtr, (remoteRenderer != null) ? remoteRenderer.GetObjectPtr():IntPtr.Zero);

			return ret;
		}
		public Boolean SendFrameWithExternalData(MediaFormat format, byte[] buffer, ulong size, ulong width, ulong height){

			IntPtr pointer = ByteArrayHelperSingleton.ByteArrayToRawPointer(buffer);
			Boolean ret = VidyoVirtualVideoSourceSendFrameWithExternalDataNative(objPtr, format, pointer, size, width, height);

			return ret;
		}
		public Boolean SetBoundsConstraints(ulong maxFrameInterval, ulong minFrameInterval, uint maxWidth, uint minWidth, uint maxHeight, uint minHeight){

			Boolean ret = VidyoVirtualVideoSourceSetBoundsConstraintsNative(objPtr, maxFrameInterval, minFrameInterval, maxWidth, minWidth, maxHeight, minHeight);

			return ret;
		}
		public Boolean SetDiscreteConstraints(ulong maxFrameInterval, ulong minFrameInterval, uint width, uint height){

			Boolean ret = VidyoVirtualVideoSourceSetDiscreteConstraintsNative(objPtr, maxFrameInterval, minFrameInterval, width, height);

			return ret;
		}
		public Boolean SetLowLatencyProfile(Boolean profile){

			Boolean ret = VidyoVirtualVideoSourceSetLowLatencyProfileNative(objPtr, profile);

			return ret;
		}
		public Boolean SetMinFrameInterval(ulong frameInterval){

			Boolean ret = VidyoVirtualVideoSourceSetMinFrameIntervalNative(objPtr, frameInterval);

			return ret;
		}
		public Boolean SetPreviewLabel(String previewLabel){

			IntPtr nPreviewLabel = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(previewLabel ?? string.Empty);
			Boolean ret = VidyoVirtualVideoSourceSetPreviewLabelNative(objPtr, nPreviewLabel);
			Marshal.FreeHGlobal(nPreviewLabel);

			return ret;
		}
		public Boolean SetStreamParametersInLocalRenderer(LocalRenderer localRenderer, uint width, uint height, ulong frameInterval){

			Boolean ret = VidyoVirtualVideoSourceSetStreamParametersInLocalRendererNative(objPtr, (localRenderer != null) ? localRenderer.GetObjectPtr():IntPtr.Zero, width, height, frameInterval);

			return ret;
		}
#if __IOS__
[ObjCRuntime.MonoPInvokeCallback(typeof(ExternalMediaBufferReleaseCallback))]
#endif
		private static void ExternalMediaBufferReleaseCallbackDelegate(IntPtr s, IntPtr buffer, ulong size, ulong userData){
			VirtualVideoSource csS = null;
			if(s != IntPtr.Zero){
				if(VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s) == IntPtr.Zero)
					csS = new VirtualVideoSource(s);
				else{
					GCHandle objHandle = (GCHandle)VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s);
					csS = (VirtualVideoSource)objHandle.Target;
				}
			}
			byte[] pointer = ByteArrayHelperSingleton.RawPointerToByteArray(buffer);
			if(csS._mIRegisterEventListener != null)
				csS._mIRegisterEventListener.ExternalMediaBufferReleaseCallback(pointer, size, userData);
		}
#if __IOS__
[ObjCRuntime.MonoPInvokeCallback(typeof(ReconfigureCallback))]
#endif
		private static void ReconfigureCallbackDelegate(IntPtr s, ulong frameInterval, MediaFormat mediaFormat, ulong userData){
			VirtualVideoSource csS = null;
			if(s != IntPtr.Zero){
				if(VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s) == IntPtr.Zero)
					csS = new VirtualVideoSource(s);
				else{
					GCHandle objHandle = (GCHandle)VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s);
					csS = (VirtualVideoSource)objHandle.Target;
				}
			}
			if(csS._mIRegisterEventListener != null)
				csS._mIRegisterEventListener.ReconfigureCallback(frameInterval, mediaFormat, userData);
		}
#if __IOS__
[ObjCRuntime.MonoPInvokeCallback(typeof(StartCallback))]
#endif
		private static void StartCallbackDelegate(IntPtr s, ulong frameInterval, MediaFormat mediaFormat, ulong userData){
			VirtualVideoSource csS = null;
			if(s != IntPtr.Zero){
				if(VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s) == IntPtr.Zero)
					csS = new VirtualVideoSource(s);
				else{
					GCHandle objHandle = (GCHandle)VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s);
					csS = (VirtualVideoSource)objHandle.Target;
				}
			}
			if(csS._mIRegisterEventListener != null)
				csS._mIRegisterEventListener.StartCallback(frameInterval, mediaFormat, userData);
		}
#if __IOS__
[ObjCRuntime.MonoPInvokeCallback(typeof(StopCallback))]
#endif
		private static void StopCallbackDelegate(IntPtr s, ulong userData){
			VirtualVideoSource csS = null;
			if(s != IntPtr.Zero){
				if(VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s) == IntPtr.Zero)
					csS = new VirtualVideoSource(s);
				else{
					GCHandle objHandle = (GCHandle)VirtualVideoSource.VidyoVirtualVideoSourceGetUserDataNative(s);
					csS = (VirtualVideoSource)objHandle.Target;
				}
			}
			if(csS._mIRegisterEventListener != null)
				csS._mIRegisterEventListener.StopCallback(userData);
		}
	};
}
